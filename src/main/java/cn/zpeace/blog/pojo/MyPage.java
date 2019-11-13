package cn.zpeace.blog.pojo;


import java.util.List;

public class MyPage<T>{

    private int pageNum;

    private int pageSize;

    private int pages;

    private int  total;

    private List<T> records;

    private int start;

    public MyPage() {
    }

    public MyPage(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public MyPage(int pageNum, int pageSize, int total) {
        this.total = total;
        this.pageSize = pageSize;
        if (pageNum < 1){
            pageNum = 1;
        }
        if (pageNum > getPages()){
            pageNum = getPages();
        }

        this.pageNum = pageNum;


    }

    public int getStart() {
        this.start = (pageNum -1) * pageSize;
        return start;
    }


    public int getPageNum() {

        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        int pages = (int)Math.ceil((double)this.total/this.pageSize);
        if (pages==0){
            pages = 1;
        }
        this.pages = pages;
        return this.pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public boolean hasPrevious(){
        return this.pageNum > 1;
    }

    public boolean hasNext(){
        return this.pageNum < this.getPages();
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", pages=" + pages +
                ", total=" + total +
                ", start=" + start +
                '}';
    }
}
