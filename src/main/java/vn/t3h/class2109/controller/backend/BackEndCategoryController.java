package vn.t3h.class2109.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.t3h.class2109.paging.PagingAndSortOject;
import vn.t3h.class2109.paging.PagingAndSortParam;
import vn.t3h.class2109.service.CategoryService;

@Controller
@RequestMapping("backend/category")
@PreAuthorize("hasAnyRole('ADMIN' , 'USER' )")
public class BackEndCategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "list")
    public String list(Model model, @PagingAndSortParam(path = "category") PagingAndSortOject page) {
        categoryService.findAll(page);
        return "backend/category/list";
    }
}
