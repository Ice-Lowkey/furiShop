package vn.t3h.class2109.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.class2109.dto.CategoryDto;
import vn.t3h.class2109.dto.ProductDto;
import vn.t3h.class2109.entities.CategoryEntity;
import vn.t3h.class2109.entities.ProductEntity;
import vn.t3h.class2109.paging.PagingAndSortOject;
import vn.t3h.class2109.paging.PagingAndSortParam;
import vn.t3h.class2109.service.CategoryService;

import javax.validation.Valid;
import java.sql.SQLException;

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

    @RequestMapping(value = "create")
    public String create(Model model) {
        model.addAttribute("cate" , "tao moi category");
        return "backend/category/create";
    }

    @RequestMapping(value = "save")
    public String save(RedirectAttributes model,
                       @Valid @ModelAttribute CategoryDto categoryDto , BindingResult bindingResult) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        if (bindingResult.hasErrors())
            return "backend/product/create";
        CategoryEntity result = categoryService.save(categoryDto);
        model.addFlashAttribute("message", "Tạo mới thành công!");
        return "redirect:/backend/category/list";
    }
}
