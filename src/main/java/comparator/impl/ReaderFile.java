package comparator.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

import comparator.Item;
import comparator.LineMsgFactory;

public class ReaderFile<T extends Item<?>> implements Iterator<T> {
	// IOC
	private volatile BufferedReader bufferedReader;
	private volatile LineMsgFactory<String, T> lineMsgFactory;

	private volatile String line;

	public ReaderFile(BufferedReader reader, LineMsgFactory<String, T> lineMsgFactory) {
		this.bufferedReader = reader;
		this.lineMsgFactory = lineMsgFactory;
	}

	public ReaderFile() {
	}

	@Override
	public boolean hasNext() {
		try {
			return (this.line = this.bufferedReader.readLine()) != null;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public T next() {
		return this.lineMsgFactory.buildLineMsg(this.line);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	public void setBufferedReader(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	public void setLineMsgFactory(LineMsgFactory<String, T> lineMsgFactory) {
		this.lineMsgFactory = lineMsgFactory;
	}
}
