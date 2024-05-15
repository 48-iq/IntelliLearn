import axios from "axios"
import { prefix } from "./shared"

const url = 'http://localhost:8080'

interface SubjectDto {
  title?: string 
  lectorId?: number 
  description?: string
}