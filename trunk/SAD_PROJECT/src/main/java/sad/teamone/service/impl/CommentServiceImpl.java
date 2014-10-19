package sad.teamone.service.impl;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.dao.CommentDAO;
import sad.teamone.entity.Comment;
import sad.teamone.service.CommentService;

/**
 * Created by QuangTV on 10/19/2014.
 */
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDAO commentDAO;


    @Override
    public Comment insert(Comment comment) {
        return (Comment) commentDAO.insert(comment);
    }


    @Override
    public Comment update(Comment comment) {
        return (Comment) commentDAO.update(comment);
    }


    @Override
    public Comment delete(Comment comment) {
        return (Comment) commentDAO.delete(comment);
    }


    @Override
    public Comment remove(int id) {
        return (Comment) commentDAO.delete(id);
    }

    @Override
    public Comment find(int id) {
        return (Comment) commentDAO.find(id);
    }
}
