package com.example.demo2.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 假分页
 * @param <T>
 */
public class Paging<T> {
    /**
     * 当前页
     */
    private final int currentPage;
    /**
     * 页总数
     */
    private final int pageCount;
    /**
     * 所有页数据
     */
    private final List<List<T>> pageData;

    /**
     *
     * @param currentPage 当前页
     * @param pageSize 页大小
     * @param dataList 所有数据
     */
    public Paging (int currentPage, int pageSize, List<T> dataList){
        this.currentPage = currentPage;
        pageData = new ArrayList<>();
        List<T> tmpList = new ArrayList<>();
        int index = 0;
        for(T data : dataList){

            if(index >= pageSize){
                pageData.add(tmpList);
                tmpList = new ArrayList<>();
                index = 0;
            }
            tmpList.add(data);
            index++;
        }
        //last time
        if(tmpList.size() > 0){
            pageData.add(tmpList);
        }


        pageCount = pageData.size();
    }

    /**
     * 获取页总数
     * @return 页总数
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * 获取当前页数据
     * @return 当前页数据
     */
    public List<T> getCurrentPageDataList() {
        if(currentPage > pageCount)
        {
            throw new NullPointerException("页面超过页总数");
        }

        if (pageData.size() == 0){
            return new ArrayList<>();
        }
        return pageData.get(currentPage - 1);
    }

    /**
     * 获取选定页数据
     * @param page 选定页
     * @return 选定页数据
     */
    public List<T> getPageDataList(int page){
        if (pageData.size() == 0){
            return new ArrayList<>();
        }
        return pageData.get(page - 1);
    }
}