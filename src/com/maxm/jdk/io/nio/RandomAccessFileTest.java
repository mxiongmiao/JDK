package com.maxm.jdk.io.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 内存映射文件I/O是一种读和写文件数据的方法，它可以比常规的基于流或者基于通道的I/O快的多。内存映射文件I/O是通过使文件中的数据出现为
 * 内存数组的内容来完成的，这其初听起来似乎不过就是将整个文件读到内存中，但是事实上并不是这样。一般来说，只有文件中实际读取或者写入的部分才会映射到内存中
 * 
 * @author maxm
 * 
 */
public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException {
		File f = new File("E:/GitHub/JDK/data/queryUser2.sh");
		// 内存映射文件
		RandomAccessFile raf = new RandomAccessFile(f, "rw");
		FileChannel fc = raf.getChannel();
		// 把通道文件的一部分映射到内存
		MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, 100);
		mbb.putChar(0, '~');
		mbb.putChar(1, '~');

		fc.close();
		raf.close();
	}
}
