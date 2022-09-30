package com.house.mbit.application.board.domain;

import com.house.mbit.core.jpa.TimeEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Board extends TimeEntity {
}
