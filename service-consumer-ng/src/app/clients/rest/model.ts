export interface AuthorDto {

  id?: string
  name: string
  description?: string

}

export interface HashTagDto {

  name: string
  description: string

}

export interface BlogPostDto {

  id?: string
  title: string
  content: string
  timestamp?: Date

}
