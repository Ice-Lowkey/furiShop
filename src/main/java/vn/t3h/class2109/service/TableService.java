package vn.t3h.class2109.service;

import vn.t3h.class2109.dto.TableDataDto;
import vn.t3h.class2109.paging.PagingAndSortOject;

public interface TableService {

    public void findAll(PagingAndSortOject page);
}
