package comparator;

import java.util.Iterator;

public class GeneralMd5MsgIteratorProxy<PROXIED> implements Iterator<Md5LineMessage>{
	private volatile Iterator<PROXIED> proxied;

	@Override
	public boolean hasNext() {
		return this.proxied.hasNext();
	}

	@Override
	public Md5LineMessage next() {
		return new Md5LineMessage(this.proxied.next().toString());
	}

	@Override
	public void remove() {
		this.proxied.remove();
	}

	public void setProxied(Iterator<PROXIED> proxied) {
		this.proxied = proxied;
	}

}
