IF OBJECT_ID('TaggedPosts', 'U') IS NOT NULL

DROP TABLE TaggedPosts

GO

CREATE TABLE TaggedPosts

(

PostId INT NOT NULL

PRIMARY KEY (tagId, PostId));