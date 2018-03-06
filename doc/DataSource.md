# Data Structure

>Tables and columns of the PHSS

## File system information layer

### filesystem_inf_main

|        Name        |   Type   | NN | UQ | UN | Default/Expression | Comment |
|:------------------:|:--------:|:--:|:--:|:--:|:------------------:|:-------:|
|      owner_id      |   UUID   | *  |    |    |                    |  PK/FK  |
|    album_count     |   INT    | *  |    | *  |         0          |         |
|    track_count     |   INT    | *  |    | *  |         0          |         |
|     book_count     |   INT    | *  |    | *  |         0          |         |
| illustration_count |   INT    | *  |    | *  |         0          |         |
|    movie_count     |   INT    | *  |    | *  |         0          |         |
|    photo_count     |   INT    | *  |    | *  |         0          |         |
|     gmt_create     | DATETIME | *  |    |    |                    |         |
|    gmt_modified    | DATETIME | *  |    |    |                    |         |

### filesystem_inf_space

|     Name     |   Type   | NN | UQ | UN | Default/Expression | Comment |
|:------------:|:--------:|:--:|:--:|:--:|:------------------:|:-------:|
|   owner_id   |   UUID   | *  |    |    |                    |  PK/FK  |
|    space     |  BIGINT  | *  |    |    |                    |         |
|  file_count  |  BIGINT  | *  |    |    |                    |         |
|  gmt_create  | DATETIME | *  |    |    |                    |         |
| gmt_modified | DATETIME | *  |    |    |                    |         |

### filesystem_file

|        Name         |   Type   | NN | UQ | UN | Default/Expression | Comment |
|:-------------------:|:--------:|:--:|:--:|:--:|:------------------:|:-------:|
|         id          |   UUID   | *  |    |    |                    |   PK    |
| filesystem_owner_id |   UUID   | *  |    |    |                    |   FK    |
|        name         | VARCHAR  | *  |    |    |                    |         |
|        type         | VARCHAR  |    |    |    |                    |         |
|     gmt_create      | DATETIME | *  |    |    |                    |         |
|    gmt_modified     | DATETIME | *  |    |    |                    |         |

## Music Albums Layer

### album_music
|        Name         |   Type   | NN | UQ | UN | Default/Expression | Comment |
|:-------------------:|:--------:|:--:|:--:|:--:|:------------------:|:-------:|
|         id          |   UUID   | *  |    |    |                    |   PK    |
| filesystem_owner_id |   UUID   | *  |    |    |                    |         |
|     album_name      | VARCHAR  | *  |    |    |                    |         |
|     gmt_create      | DATETIME | *  |    |    |                    |         |

### album_music_inf

|      Name      |   Type   | NN | UQ | UN | Default/Expression | Comment |
|:--------------:|:--------:|:--:|:--:|:--:|:------------------:|:-------:|
|    album_id    |   UUID   | *  |    |    |                    |  PK/FK  |
|     artist     | VARCHAR  |    |    |    |                    |         |
|  album_artist  | VARCHAR  |    |    |    |                    |         |
|    composer    | VARCHAR  |    |    |    |                    |         |
|     genre      | VARCHAR  |    |    |    |                    |         |
| playback_count |   INT    | *  |    | *  |         0          |         |
|   gmt_create   | DATETIME | *  |    |    |                    |         |
|  gmt_modified  | DATETIME | *  |    |    |                    |         |


### album_music_inf_static

|     Name      |   Type   | NN | UQ | UN | Default/Expression | Comment |
|:-------------:|:--------:|:--:|:--:|:--:|:------------------:|:-------:|
|   album_id    |   UUID   | *  |    |    |                    |  PK/FK  |
| album_artwork | LONGBLOB |    |    |    |                    |         |
| release_year  |   YEAR   |    |    |    |                    |         |
|    tracks     | TINYINT  |    |    |    |                    |         |
|  disc_number  | TINYINT  |    |    |    |                    |         |
|    rating     |  FLOAT   |    |    |    |                    |         |
|   comments    |   TEXT   |    |    |    |                    |         |
|  gmt_create   | DATETIME | *  |    |    |                    |         |
| gmt_modified  | DATETIME | *  |    |    |                    |         |


### track

|     Name     |   Type   | NN | UQ | UN | Default/Expression | Comment |
|:------------:|:--------:|:--:|:--:|:--:|:------------------:|:-------:|
|      id      |   UUID   | *  |    |    |                    |   PK    |
|   album_id   |   UUID   |    |    |    |                    |   FK    |
|  track_name  | VARCHAR  | *  |    |    |                    |         |
|  gmt_create  | DATETIME | *  |    |    |                    |         |
| gmt_modified | DATETIME | *  |    |    |                    |         |

### track_inf

|      Name      |   Type   | NN | UQ | UN | Default/Expression | Comment |
|:--------------:|:--------:|:--:|:--:|:--:|:------------------:|:-------:|
|    track_id    |   UUID   | *  |    |    |                    |  PK/FK  |
|     artist     | VARCHAR  |    |    |    |                    |         |
|  album_artist  | VARCHAR  |    |    |    |                    |         |
|    composer    | VARCHAR  |    |    |    |                    |         |
|     genre      | VARCHAR  |    |    |    |                    |         |
| playback_count | VARCHAR  | *  |    |    |         0          |         |
|   gmt_create   | DATETIME | *  |    |    |                    |         |
|  gmt_modified  | DATETIME | *  |    |    |                    |         |

### track_inf_static

|     Name      |   Type   | NN | UQ | UN | Default/Expression | Comment |
|:-------------:|:--------:|:--:|:--:|:--:|:------------------:|:-------:|
|   track_id    |   UUID   | *  |    |    |                    |  PK/FK  |
| album_artwork | LONGBLOB |    |    |    |                    |         |
| release_year  |   YEAR   |    |    |    |                    |         |
|  disc_number  | TINYINT  |    |    |    |                    |         |
|    rating     |  FLOAT   |    |    |    |                    |         |
|   comments    |   TEXT   |    |    |    |                    |         |
|    lyrics     | LONGTEXT |    |    |    |                    |         |
|      mv       | VARCHAR  |    |    |    |                    |         |

## Movies Layer

### movie

|    Name    |  Type   | NN | UQ | UN | Default/Expression | Comment |
|:----------:|:-------:|:--:|:--:|:--:|:------------------:|:-------:|
|     id     |  UUID   | *  |    |    |                    |   PK    |
|  owner_id  |  UUID   | *  |    |    |                    |   FK    |
| movie_name | VARCHAR | *  |    |    |                    |         |

### movie_inf

|      Name      |   Type   | NN | UQ | UN | Default/Expression | Comment |
|:--------------:|:--------:|:--:|:--:|:--:|:------------------:|:-------:|
|    movie_id    |   UUID   | *  |    |    |                    |  PK/FK  |
| content_rating | VARCHAR  |    |    |    |                    |         |
|   movie_time   | VARCHAR  |    |    |    |                    |         |
|     genre      | VARCHAR  |    |    |    |                    |         |
|  release_date  |   DATE   |    |    |    |                    |         |
|     poster     | LONGBLOB |    |    |    |                    |         |
|     rating     |  FLOAT   |    |    |    |                    |         |
|    director    | VARCHAR  |    |    |    |                    |         |
|    writers     | VARCHAR  |    |    |    |                    |         |
|     stars      | VARCHAR  |    |    |    |                    |         |
|   metascore    |   INT    |    |    |    |                    |         |

### anime

|    Name    |  Type   | NN | UQ | UN | Default/Expression | Comment |
|:----------:|:-------:|:--:|:--:|:--:|:------------------:|:-------:|
|     id     |  UUID   | *  |    |    |                    |   PK    |
|  owner_id  |  UUID   | *  |    |    |                    |   FK    |
| anime_name | VARCHAR |    |    |    |                    |         |

### anime_inf

|      Name       |  Type   | NN | UQ | UN | Default/Expression | Comment |
|:---------------:|:-------:|:--:|:--:|:--:|:------------------:|:-------:|
|    anime_id     |  UUID   | *  |    |    |                    |  PK/FK  |
|     gensaku     | VARCHAR |    |    |    |                    |         |
| gensaku_irasuto | VARCHAR |    |    |    |                    |         |
|     seiyuu      | VARCHAR |    |    |    |                    |         |
|     kantoku     | VARCHAR |    |    |    |                    |         |
|     ongaku      | VARCHAR |    |    |    |                    |         |
|      year       | VARCHAR |    |    |    |                    |         |
|   season_time   | VARCHAR |    |    |    |                    |         |
|  season_anime   | VARCHAR |    |    |    |                    |         |

### video

|    Name    |  Type   | NN | UQ | UN | Default/Expression | Comment |
|:----------:|:-------:|:--:|:--:|:--:|:------------------:|:-------:|
|     id     |  UUID   | *  |    |    |                    |   PK    |
|  owner_id  |  UUID   | *  |    |    |                    |   FK    |
| video_name | VARCHAR |    |    |    |                    |         |
|    type    | VARCHAR |    |    |    |                    |         |

### video_inf

|     Name     | Type | NN | UQ | UN | Default/Expression | Comment |
|:------------:|:----:|:--:|:--:|:--:|:------------------:|:-------:|
|   video_id   | UUID |    |    |    |                    |  PK/FK  |
| x_resolution | INT  |    |    |    |                    |         |
| y_resolution | INT  |    |    |    |                    |         |

## Books Layer

### book

|     Name     |   Type   | NN | UQ | UN | Default/Expression | Comment |
|:------------:|:--------:|:--:|:--:|:--:|:------------------:|:-------:|
|      id      |   UUID   | *  |    |    |                    |   PK    |
|   owner_id   |   UUID   | *  |    |    |                    |  PK/FK  |
|  book_name   | VARCHAR  | *  |    |    |                    |         |
|  gmt_create  | DATETIME | *  |    |    |                    |         |
| gmt_modified | DATETIME | *  |    |    |                    |         |

### book_inf

|     Name     |   Type   | NN | UQ | UN | Default/Expression | Comment |
|:------------:|:--------:|:--:|:--:|:--:|:------------------:|:-------:|
|   book_id    |   UUID   |    |    |    |                    |  PK/FK  |
|    author    | VARCHAR  |    |    |    |                    |         |
| illustrator  | VARCHAR  |    |    |    |                    |         |
| release_date | DATETIME |    |    |    |                    |         |
|     ISBN     |   INT    |    |    |    |                    |         |
|  gmt_create  | DATETIME | *  |    |    |                    |         |
| gmt_modified | DATETIME | *  |    |    |                    |         |

## Photo Albums Layer

### album_photo

|     Name     |   Type   | NN | UQ | UN | Default/Expression | Comment |
|:------------:|:--------:|:--:|:--:|:--:|:------------------:|:-------:|
|      id      |   UUID   | *  |    |    |                    |   PK    |
|   owner_id   |   UUID   |    |    |    |                    |   FK    |
|  album_name  | VARCHAR  | *  |    |    |                    |         |
|  gmt_create  | DATETIME |    |    |    |                    |         |
| gmt_modified | DATETIME |    |    |    |                    |         |


### album_photo_inf

|     Name     |   Type   | NN | UQ | UN | Default/Expression | Comment |
|:------------:|:--------:|:--:|:--:|:--:|:------------------:|:-------:|
|   album_id   |   UUID   | *  |    |    |                    |  PK/FK  |
|  gmt_create  | DATETIME |    |    |    |                    |         |
| gmt_modified | DATETIME |    |    |    |                    |         |

### photo

|    Name    |  Type   | NN | UQ | UN | Default/Expression | Comment |
|:----------:|:-------:|:--:|:--:|:--:|:------------------:|:-------:|
|     id     |  UUID   | *  |    |    |                    |   PK    |
|  album_id  |  UUID   |    |    |    |                    |         |
| photo_name | VARCHAR |    |    |    |                    |         |

### photo_inf

|     Name      |   Type    | NN | UQ | UN | Default/Expression | Comment |
|:-------------:|:---------:|:--:|:--:|:--:|:------------------:|:-------:|
|   photo_id    |   UUID    | *  |    |    |                    |  PK/FK  |
| x_resolution  |    INT    |    |    |    |                    |         |
| y_resolution  |    INT    |    |    |    |                    |         |
| manufacturer  |  VARCHAR  |    |    |    |                    |         |
|     model     |  VARCHAR  |    |    |    |                    |         |
|   date_time   | TIMESTAMP |    |    |    |                    |         |
|  compression  |  VARCHAR  |    |    |    |                    |         |
| exposure_time |    INT    |    |    |    |                    |         |
|   f_number    |  VARCHAR  |    |    |    |                    |         |
|     flash     |  VARCHAR  |    |    |    |                    |         |
| focal_length  |   FLOAT   |    |    |    |                    |         |
|  color_space  |  VARCHAR  |    |    |    |                    |         |
|  gmt_create   | DATETIME  |    |    |    |                    |         |
| gmt_modified  | DATETIME  |    |    |    |                    |         |


















