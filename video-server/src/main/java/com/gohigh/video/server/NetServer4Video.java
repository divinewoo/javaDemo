package com.gohigh.video.server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NetServer4Video {

	ServerSocketChannel ssc;

	public void start()

	{

		try

		{

			Selector selector = Selector.open();

			ServerSocketChannel ssc = ServerSocketChannel.open();

			ssc.configureBlocking(false);

			ServerSocket ss = ssc.socket();

			InetSocketAddress address = new InetSocketAddress(55555);

			ss.bind(address);

			ssc.register(selector, SelectionKey.OP_ACCEPT);

			System.out.println("端口注册完毕!");

			while (true)

			{

				selector.select();

				Set<SelectionKey> selectionKeys = selector.selectedKeys();

				Iterator<SelectionKey> iter = selectionKeys.iterator();

				ByteBuffer echoBuffer = ByteBuffer.allocate(20);

				SocketChannel sc;

				while (iter.hasNext())

				{

					SelectionKey key = iter.next();

					if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT)

					{

						ServerSocketChannel subssc = (ServerSocketChannel) key
								.channel();

						sc = subssc.accept();

						sc.configureBlocking(false);

						sc.register(selector, SelectionKey.OP_READ);

						iter.remove();

						System.out.println("有新连接:" + sc);

					}

					else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ)

					{

						sc = (SocketChannel) key.channel();

						while (true)

						{

							echoBuffer.clear();

							int a;

							try

							{

								a = sc.read(echoBuffer);

							}

							catch (Exception e)

							{

								e.printStackTrace();

								break;

							}

							if (a == -1)
								break;

							if (a > 0)

							{

								byte[] b = echoBuffer.array();

								System.out.println("接收数据: " + new String(b));

								echoBuffer.flip();

								sc.write(echoBuffer);

								System.out.println("返回数据: " + new String(b));

							}

						}

						sc.close();

						System.out.println("连接结束");

						System.out.println("=============================");

						iter.remove();

					}

				}

			}

		}

		catch (Exception e)

		{

			e.printStackTrace();

		}

	}

	public static void main(String[] args) {
		new NetServer4Video().start();
	}

}
