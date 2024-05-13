import { DashboardPage } from "@/pages/dashboard";
import { LoginPage } from "@/pages/login";
import { createBrowserRouter } from "react-router-dom";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <DashboardPage />,
  },
  {
    path: '/loginasdads',
    element: <LoginPage />
  }
])