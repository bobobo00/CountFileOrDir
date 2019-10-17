package cn.io.study01;

import java.io.File;

public class Count {
	private long dirsize;
	private String dirpath;
	private File src;
	private int numFile;
	private int numDir=-1;
	
	
	public Count(String dirpath) {
		this.dirpath=dirpath;
		this.src=new File(dirpath);
		this.count(src);
	}
	
	


	private long count(File src) {
		if(null!=src&&src.exists()) {
			if(src.isFile()) {
				this.numFile++;
				dirsize+=src.length();
			}else {
				this.numDir++;
				for(File f:src.listFiles()) {
					count(f);
				}
			}
		}
		return dirsize;
	}
	
	public long getDirSize() {
		return this.dirsize;
	}

	public int getNumFile() {
		return this.numFile;
	}

	public int getNumDir() {
		return this.numDir;
	}

	public static void main(String[] args) {
		Count count=new Count("E:/workspace-java/IOÁ÷¼¼Êõ/src");
		System.out.println(count.getDirSize()+"->"+count.getNumDir()+"->"+count.getNumFile());
	}

}
