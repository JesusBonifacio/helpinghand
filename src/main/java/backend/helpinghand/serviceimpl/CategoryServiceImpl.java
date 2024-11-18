package backend.helpinghand.serviceimpl;

import backend.helpinghand.entities.Category;
import backend.helpinghand.entities.Comment;
import backend.helpinghand.repositories.CategoryRepository;
import backend.helpinghand.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> listAllCategorys() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }
}
