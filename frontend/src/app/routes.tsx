import { DashboardPage } from "@/pages/dashboard"
import { LoginPage } from "@/pages/login"
import { ArchiveTaskPage } from "@/pages/task/archive"
import { CreateTaskPage } from "@/pages/task/create"
import { CreateUserPage } from "@/pages/user/create"
import { SingleUserPage } from "@/pages/user/single"
import { createBrowserRouter } from "react-router-dom"

export const router = createBrowserRouter([
  {
    path: "/",
    element: <DashboardPage />,
    
  },
  {
    path: 'auth/login',
    element: <LoginPage />
  },
  {
    path: 'users/user',
    element: <SingleUserPage />
  },
  {
    path: 'create/task',
    element: <CreateTaskPage />,
  },
  {
    path: 'auth/registration',
    element: <CreateUserPage />
  },
  {
    path: 'tasks',
    element: <ArchiveTaskPage />
  }
])