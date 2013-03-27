package com.demo1.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiesCollectionsDemo {
	public static void main(String[] args) {
		final DataSample ds = new DataSample();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						System.out.println("Name= " + ds.getName(0));
						Thread.sleep(2000);

					} catch (Exception e) {
						try {
							Thread.sleep(2000);
						} catch (Exception ex) {
						}
						// e.printStackTrace();
					}
				}
			}

		}).start();
		new Thread(new Runnable() {
			public void run() {
				try {
					ds.setName(0, "�ܶ���");
					Thread.sleep(2000);
					ds.setName(0, "��Сƽ");
					Thread.sleep(2000);
					ds.setName(0, "����");
					Thread.sleep(2000);
					ds.setName(0, "���F��");
					Thread.sleep(2000);
					ds.setName(0, "�¼ұ�");
					Thread.sleep(2000);
					ds.setName(0, "���ǿ");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}

class DataSample {
	private List<String> names;
	private List<String> unmodifiesList;

	public DataSample() {
		names = Collections.synchronizedList(new ArrayList<String>(10));
		unmodifiesList = Collections.unmodifiableList(names);
	}

	public synchronized void setName(int index, String name) {
		if (this.names.size() == 0) {
			this.names.add(name);
		} else {
			this.names.set(index, name);
		}
	}

	public String getName(int index) {
		return unmodifiesList.get(index);
	}
}
