package com.example.serviceImpl;

import com.example.entity.Reaction;
import com.example.repository.ReactionRepository;
import com.example.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReactionServiceImpl implements ReactionService {

    @Autowired
    private ReactionRepository reactionRepository;

    @Override
    public List<Reaction> findAll() {
        return reactionRepository.findAll();
    }

    @Override
    public Optional<Reaction> findById(Long id) {
        return reactionRepository.findById(id);
    }

    @Override
    public Reaction save(Reaction reaction) {
        return reactionRepository.save(reaction);
    }

    @Override
    public void deleteById(Long id) {
        reactionRepository.deleteById(id);
    }
}