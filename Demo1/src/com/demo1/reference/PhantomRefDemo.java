package com.demo1.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomRefDemo {
    public PhantomRefDemo() {
    }

    public static void main(String[] args) {
        Demo o = new Demo();
        ReferenceQueue<Demo> queue = new ReferenceQueue<Demo>();
        PhantomReference<Demo> pha = new PhantomReference<Demo>(o, queue);

        System.out.println(pha.isEnqueued());
        System.out.println("============");
        o = null;
        System.gc();

        System.out.println(pha.isEnqueued());

        System.out.println("=============");
        System.out.println(queue.poll() == null);
        System.out.println("===============");
        System.out.println(o == null);
        pha.clear();
        System.out.println("==============");
        System.out.println(o == null);
        // System.out.println(pha.isEnqueued());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#finalize()
     */
    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("finalize****");
        // PhantomRefDemo demo = this;
        super.finalize();
    }

}
