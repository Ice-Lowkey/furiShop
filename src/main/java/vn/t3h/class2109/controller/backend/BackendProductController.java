package vn.t3h.class2109.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.class2109.dto.ProductDto;
import vn.t3h.class2109.entities.ProductEntity;
import vn.t3h.class2109.paging.PagingAndSortOject;
import vn.t3h.class2109.paging.PagingAndSortParam;
import vn.t3h.class2109.service.CategoryService;
import vn.t3h.class2109.service.ProductService;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("backend/product")
@PreAuthorize("hasAnyRole('ADMIN' , 'USER' )")
public class BackendProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    // Load trang tạo mới sản phẩm
    @RequestMapping(value = "create")
    public String create(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "backend/product/create";
    }

    @RequestMapping(value = "edit/{id}")
    public String edit(Model model, ProductDto productDto, @PathVariable Long id ) {
        model.addAttribute("value" , productService.findById(id));
        model.addAttribute("product", productService.editProduct(productDto));
        model.addAttribute("categories", categoryService.getAll());
        return "backend/product/edit";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(RedirectAttributes model, @PathVariable Long id) {
        model.addFlashAttribute("xóa thành công", productService.delete(id));
        return "redirect:/backend/product/list";
    }

    // Load trang danh sách sản phẩm
    @RequestMapping(value = "list")
    public String list(Model model, @PagingAndSortParam(path = "product") PagingAndSortOject page) {
        productService.findAll(page);
        return "backend/product/list";
    }


//    // Submit tạo mới sản phẩm
//    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    // đánh dấu đường dẫn của web
//    public String taoMoiSanPham(Model model, ProductDto productDto) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
//        // viết hàm lưu vào db
//        boolean result = productService.saveProduct(productDto);
//        if (result){
//            if (productDto.getId() == null)
//                model.addAttribute("message", "Tạo mới thành công!");
//            else
//                model.addAttribute("message", "Sửa thành công!");
//        }
//        else
//            model.addAttribute("message", "Thao tác thất bại!");
//        return "backend/product/list";// đọc text từ file jsp và render ra html
//    }

    // Submit tạo mới sản phẩm
    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    // đánh dấu đường dẫn của web
    public String taoMoiSanPham(RedirectAttributes model,
                                @Valid @ModelAttribute ProductDto productDto , BindingResult bindingResult) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        // viết hàm lưu vào db
        if (bindingResult.hasErrors())
            return "backend/product/create";
        ProductEntity result = productService.saveProduct(productDto);
        model.addFlashAttribute("message", "Tạo mới thành công!");
        return "redirect:/backend/product/list";
    }
}
