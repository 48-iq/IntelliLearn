import { DashboardPage } from "@/pages/dashboard"
import { LoginPage } from "@/pages/login"
import { SingleUserPage } from "@/pages/user/single"
import { createBrowserRouter } from "react-router-dom"

export const router = createBrowserRouter([
  {
    path: "/",
    element: <DashboardPage />,
    
  },
  {
    path: '/loginasdads',
    element: <LoginPage />
  },
  {
    path: 'users/user',
    element: <SingleUserPage />
  }
])