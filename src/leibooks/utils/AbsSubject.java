package leibooks.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <E>
 * 
 * Represents objects that are being observed by a list of 
 * listeners of events of type E.
 * 
 */
public abstract class AbsSubject<E extends Event> implements Subject<E> {
	
	protected List<Listener<E>> listeners = new ArrayList<>();
	
	protected  AbsSubject() {}
	
	/**
	 * Emits a given event to the listeners
	 * 
	 * @param e event that occurred
	 */
	@Override
	public void emitEvent(E e) {
		for (Listener<E> o : listeners) {
			o.processEvent(e);
		}
	}
	
	/**
	 * Registers a new listener
	 * 
	 * @param obs listener to be added 
	 */
	@Override
	public synchronized void registerListener(Listener<E> obs) {
		if (obs != null && !listeners.contains(obs)) 
			listeners.add(obs);
	}
	
	/**
	 * Removes the registry of the given listener
	 * 
	 * @param obs listener to be removed
	 */
	@Override
	public synchronized void unregisterListener(Listener<E> obs) {
		if (obs != null) 
			listeners.remove(obs);
	}

}
