package sad.teamone.service;

import sad.teamone.entity.Category;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface CategoryService {

    Boolean insert(Category category);
    Boolean update(Category category);
    Boolean delete(Category category);
    Boolean remove(int i);
    Category find(int id);
}
