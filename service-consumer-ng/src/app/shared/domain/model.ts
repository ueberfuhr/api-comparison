export interface Author {

  id?: string
  name: string
  description?: string

}

export interface HashTag {

  name: string
  description?: string

}

export interface BlogPost {

  id?: string
  title: string
  content: string
  timestamp?: Date
  author?: Author
  tags: string[]

}
