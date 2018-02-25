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

|        Name         |    Type     | NN | UQ | UN | Default/Expression | Comment |
|:-------------------:|:-----------:|:--:|:--:|:--:|:------------------:|:-------:|
|         id          |    UUID     | *  |    |    |                    |   PK    |
| filesystem_owner_id |    UUID     | *  |    |    |                    |   FK    |
|        name         | VARCHAR(45) | *  |    |    |                    |         |
|        type         | VARCHAR(45) |    |    |    |                    |         |
|     gmt_create      |  DATETIME   | *  |    |    |                    |         |
|    gmt_modified     |  DATETIME   | *  |    |    |                    |         |

## Music Albums Layer

### album_music
|        Name         |    Type     | NN | UQ | UN | Default/Expression | Comment |
|:-------------------:|:-----------:|:--:|:--:|:--:|:------------------:|:-------:|
|         id          |    UUID     | *  |    |    |                    |   PK    |
| filesystem_owner_id |    UUID     | *  |    |    |                    |         |
|     album_name      | VARCHAR(45) | *  |    |    |                    |         |
|     gmt_create      |  DATETIME   | *  |    |    |                    |         |

### album_music_inf

|      Name      |    Type     | NN | UQ | UN | Default/Expression | Comment |
|:--------------:|:-----------:|:--:|:--:|:--:|:------------------:|:-------:|
|    album_id    |    UUID     | *  |    |    |                    |  PK/FK  |
|     artist     | VARCHAR(45) |    |    |    |                    |         |
|  album_artist  | VARCHAR(45) |    |    |    |                    |         |
|    composer    | VARCHAR(45) |    |    |    |                    |         |
|     genre      | VARCHAR(45) |    |    |    |                    |         |
| playback_count |     INT     | *  |    | *  |         0          |         |
|   gmt_create   |  DATETIME   | *  |    |    |                    |         |
|  gmt_modified  |  DATETIME   | *  |    |    |                    |         |


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

|     Name     |    Type     | NN | UQ | UN | Default/Expression | Comment |
|:------------:|:-----------:|:--:|:--:|:--:|:------------------:|:-------:|
|      id      |    UUID     | *  |    |    |                    |   PK    |
|   album_id   |    UUID     |    |    |    |                    |   FK    |
|  track_name  | VARCHAR(45) | *  |    |    |                    |         |
|  gmt_create  |  DATETIME   | *  |    |    |                    |         |
| gmt_modified |  DATETIME   | *  |    |    |                    |         |

### track_inf

|      Name      |    Type     | NN | UQ | UN | Default/Expression | Comment |
|:--------------:|:-----------:|:--:|:--:|:--:|:------------------:|:-------:|
|    track_id    |    UUID     | *  |    |    |                    |  PK/FK  |
|     artist     | VARCHAR(45) |    |    |    |                    |         |
|  album_artist  | VARCHAR(45) |    |    |    |                    |         |
|    composer    | VARCHAR(45) |    |    |    |                    |         |
|     genre      | VARCHAR(45) |    |    |    |                    |         |
| playback_count | VARCHAR(45) | *  |    |    |         0          |         |
|   gmt_create   |  DATETIME   | *  |    |    |                    |         |
|  gmt_modified  |  DATETIME   | *  |    |    |                    |         |

### track_inf_static

|     Name      |    Type     | NN | UQ | UN | Default/Expression | Comment |
|:-------------:|:-----------:|:--:|:--:|:--:|:------------------:|:-------:|
|   track_id    |    UUID     | *  |    |    |                    |  PK/FK  |
| album_artwork |  LONGBLOB   |    |    |    |                    |         |
| release_year  |    YEAR     |    |    |    |                    |         |
|  disc_number  |   TINYINT   |    |    |    |                    |         |
|    rating     |    FLOAT    |    |    |    |                    |         |
|   comments    |    TEXT     |    |    |    |                    |         |
|    lyrics     |  LONGTEXT   |    |    |    |                    |         |
|      mv       | VARCHAR(45) |    |    |    |                    |         |

## Books Layer

### book

|     Name     |    Type     | NN | UQ | UN | Default/Expression | Comment |
|:------------:|:-----------:|:--:|:--:|:--:|:------------------:|:-------:|
|      id      |    UUID     | *  |    |    |                    |   PK    |
|   owner_id   |    UUID     | *  |    |    |                    |  PK/FK  |
|  book_name   | VARCHAR(45) | *  |    |    |                    |         |
|  gmt_create  |  DATETIME   | *  |    |    |                    |         |
| gmt_modified |  DATETIME   | *  |    |    |                    |         |

### book_inf

|     Name     |    Type     | NN | UQ | UN | Default/Expression | Comment |
|:------------:|:-----------:|:--:|:--:|:--:|:------------------:|:-------:|
|   book_id    |    UUID     |    |    |    |                    |  PK/FK  |
|    author    | VARCHAR(45) |    |    |    |                    |         |
| illustrator  | VARCHAR(45) |    |    |    |                    |         |
| release_date |  DATETIME   |    |    |    |                    |         |
|     ISBN     |     INT     |    |    |    |                    |         |
|  gmt_create  |  DATETIME   | *  |    |    |                    |         |
| gmt_modified |  DATETIME   | *  |    |    |                    |         |

## Movies Layer

### movie

|    Name    |    Type     | NN | UQ | UN | Default/Expression | Comment |
|:----------:|:-----------:|:--:|:--:|:--:|:------------------:|:-------:|
|     id     |    UUID     | *  |    |    |                    |   PK    |
|  owner_id  |    UUID     | *  |    |    |                    |   FK    |
| movie_name | VARCHAR(45) | *  |    |    |                    |         |

### movie_inf















