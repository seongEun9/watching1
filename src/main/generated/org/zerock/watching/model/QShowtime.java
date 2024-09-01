package org.zerock.watching.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShowtime is a Querydsl query type for Showtime
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShowtime extends EntityPathBase<Showtime> {

    private static final long serialVersionUID = -2109309802L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShowtime showtime = new QShowtime("showtime");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMovie movie;

    public final DateTimePath<java.time.LocalDateTime> startTime = createDateTime("startTime", java.time.LocalDateTime.class);

    public final QTheater theater;

    public QShowtime(String variable) {
        this(Showtime.class, forVariable(variable), INITS);
    }

    public QShowtime(Path<? extends Showtime> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShowtime(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShowtime(PathMetadata metadata, PathInits inits) {
        this(Showtime.class, metadata, inits);
    }

    public QShowtime(Class<? extends Showtime> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.movie = inits.isInitialized("movie") ? new QMovie(forProperty("movie")) : null;
        this.theater = inits.isInitialized("theater") ? new QTheater(forProperty("theater")) : null;
    }

}

