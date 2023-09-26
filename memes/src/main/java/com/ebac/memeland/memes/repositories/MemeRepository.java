package com.ebac.memeland.memes.repositories;

import com.ebac.memeland.memes.entities.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends JpaRepository<Meme, Long> {
}
