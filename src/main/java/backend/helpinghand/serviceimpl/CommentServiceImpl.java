package backend.helpinghand.serviceimpl;

import backend.helpinghand.entities.Comment;
import backend.helpinghand.entities.Profile;
import backend.helpinghand.repositories.CommentRepository;
import backend.helpinghand.repositories.ProfileRepository;
import backend.helpinghand.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    private ProfileRepository profileRepository;

    @Override
    public List<Comment> listAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> listCommentsByProfileName(String profileName) {
        return commentRepository.findByProfile_NameContains(profileName);
    }

    @Override
    public List<Comment> listCommentsByCampaignId(Long id) {
        return List.of();
    }
}
