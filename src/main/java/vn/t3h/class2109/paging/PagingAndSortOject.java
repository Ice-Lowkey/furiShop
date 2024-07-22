package vn.t3h.class2109.paging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.StringUtils;
import org.springframework.web.method.support.ModelAndViewContainer;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagingAndSortOject {
    private Integer page = 1;
    private Integer perpage = 5;
    private String sort;
    private String keyword;
    private String path;
    private String field;
    private ModelAndViewContainer model;


    public void findAll(JpaRepository<?, Long> repository) {
        Sort sortPage = null;
        if (!StringUtils.isEmpty(field)) {
            sortPage = Sort.by(field);
            if ("asc".equals(sort)) {
                sortPage = sortPage.ascending();
            }
            else {
                sortPage = sortPage.descending();
            }
        }
        Page<?> result = repository.findAll(PageRequest.of(page - 1 , perpage , sortPage));
        model.addAttribute("data", result.getContent());
        model.addAttribute("page", page);
        model.addAttribute("perpage", perpage);
        model.addAttribute("field", field);
        model.addAttribute("sort", sort);
        model.addAttribute("path", path);
        model.addAttribute("totalPage", result.getTotalPages());
    }
}
