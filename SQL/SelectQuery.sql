SELECT Image, lat, long FROM Posts;


SELECT Tags.tagId, TaggedPosts.PostId, Tags.tagname
FROM TaggedPosts
INNER JOIN Tags ON TaggedPosts.tagId=Tags.tagId;