package sad.teamone.service.impl;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.dao.CommentDAO;
import sad.teamone.entity.Comment;
import sad.teamone.service.CommentService;

import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDAO commentDAO;


    @Override
    public Boolean insert(Comment comment) {
        return commentDAO.insert(comment);
    }


    @Override
    public Boolean update(Comment comment) {
        return commentDAO.update(comment);
    }


    @Override
    public Boolean delete(Comment comment) {
        return commentDAO.delete(comment);
    }


    @Override
    public Boolean remove(int id) {
        return  commentDAO.delete(id);
    }

    @Override
    public Comment find(int id) {
        return (Comment) commentDAO.find(id);
    }

    @Override
    public List findByJobId(int jobID){
        return commentDAO.findByJobId(jobID);
    }

    @Override
    public List findToday() {
        return commentDAO.findToday();
    }

    @Override
    public List findAll() {
        return commentDAO.findAll();
    }
}
