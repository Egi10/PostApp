package id.buaja.data.mapper

import id.buaja.data.source.post.response.PostCommentsResponseItem
import id.buaja.data.source.post.response.PostResponseItem
import id.buaja.data.source.users.response.UsersResponse
import id.buaja.domain.model.Post
import id.buaja.domain.model.PostComments

object DataMapper {
    fun mapResponseToModelPost(
        post: PostResponseItem,
        user: UsersResponse
    ): List<Post> {
        return listOf(
            Post(
                id = post.id ?: 0,
                idUser = post.userId ?: 0,
                title = post.title ?: "",
                body = post.body?.replace("\n", " ") ?: "",
                userName = user.name ?: "",
                userCompanyName = user.company?.name ?: ""
            )
        )
    }

    fun mapResponseToModelPostComments(
        postComments: List<PostCommentsResponseItem>
    ): List<PostComments> {
        val list: MutableList<PostComments> = mutableListOf()

        postComments.map {
            list.add(
                PostComments(
                    name = it.name ?: "",
                    body = it.body?.replace("\n", " ") ?: ""
                )
            )
        }
        
        return list
    }
}