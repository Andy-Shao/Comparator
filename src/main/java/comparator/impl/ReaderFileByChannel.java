package comparator.impl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Iterator;

import andy.shao.util.ArrayTools;

import comparator.Item;
import comparator.LineMsgFactory;

/**
 * Thread is unsafe.
 * 
 * @author ws83149
 * 
 * @param <T>
 */
public class ReaderFileByChannel<T extends Item<?>> implements Iterator<T> {
	// IOC
	protected volatile ByteBuffer readerBuffer = ByteBuffer.allocate(1024 * 1024 * 10);
	protected volatile ReadableByteChannel readableByteChannel;
	private volatile LineMsgFactory<String, T> lineMsgFactory;
	private byte sight = '\n';

	private byte[] surplus = new byte[0];
	static final byte END_SIT = '\n';
	static final byte OTHER_END_SIT = '\r';

	@Override
	public boolean hasNext() {
		if (this.surplus.length > 0) return true;
		else {
			int index = readAndLoad();
			if (index != -1) return true;
			else return false;
		}
	}

	protected int readAndLoad() {
		int index = read(this.readableByteChannel, this.readerBuffer);
		this.surplus = ArrayTools.mergeArray(byte[].class, this.surplus, getMsg(this.readerBuffer));
		return index;
	}

	protected static int read(ReadableByteChannel channel, ByteBuffer buffer) {
		int index = 0;
		try {
			index = channel.read(buffer);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return index;
	}

	protected static byte[] getMsg(ByteBuffer byteBuffer) {
		byteBuffer.limit(byteBuffer.position());
		byteBuffer.position(0);
		byte[] result = new byte[byteBuffer.limit()];
		byteBuffer.get(result);
		byteBuffer.limit(byteBuffer.capacity());
		byteBuffer.position(0);
		return result;
	}

	@Override
	public T next() {
		T result = null;
		int index = ArrayTools.findFirstItem(this.surplus, this.sight);

		if (this.surplus.length > 0 && index != -1) {
			result = this.lineMsgFactory.buildLineMsg(new String(ArrayTools.splitArray(this.surplus, 0, index)));
			this.surplus = ArrayTools.splitArray(this.surplus, index + 1, this.surplus.length);
		} else {
			int load = this.readAndLoad();
			if (load != -1) result = this.next();
			else result = this.lineMsgFactory.buildLineMsg(new String(this.surplus));
		}

		return result;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	public void setReadableByteChannel(ReadableByteChannel readableByteChannel) {
		this.readableByteChannel = readableByteChannel;
	}

	public void setCacheSize(int size) {
		this.readerBuffer = ByteBuffer.allocate(size);
	}

	public void setLineMsgFactory(LineMsgFactory<String, T> lineMsgFactory) {
		this.lineMsgFactory = lineMsgFactory;
	}

	public void setSight(int sight) {
		this.sight = (byte) sight;
	}
}
