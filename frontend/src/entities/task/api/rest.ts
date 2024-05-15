import axios from "axios"
import { prefix } from "./shared"

const url = 'http://localhost:8080'

interface TaskDto {
  name?: string 
  description?: string 
  // file?:   
  startDate?: string 
  endDate?: string
}