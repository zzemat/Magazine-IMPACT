import axios from "axios";

const API_BASE_URL = "http://localhost:8010/api"; 

// Création d'une instance Axios
const apiClient = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    "Content-Type": "application/json",
  },
});

apiClient.interceptors.request.use(
  (config) => {
    if (typeof window !== "undefined") {
      const accessToken = localStorage.getItem("accessToken");
      if (accessToken) {
        config.headers.Authorization = `Bearer ${accessToken}`;
      }
    }
    return config;
  },
  (error) => Promise.reject(error)
);

const logout = () => {
  localStorage.removeItem("accessToken");
  document.cookie = "refreshToken=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
  window.location.href = "/login";
};

apiClient.interceptors.response.use(
  (response) => response,
  async (error) => {
    if (error.response?.status === 401) {
      try {
        const refreshToken = document.cookie
          .split("; ")
          .find((row) => row.startsWith("refreshToken="))
          ?.split("=")[1];

        if (!refreshToken) {
          throw new Error("No refresh token found");
        }

        const response = await axios.post(
          `${API_BASE_URL}/auth/refresh`,
          {},
          {
            headers: { Authorization: `Bearer ${refreshToken}` },
          }
        );

        localStorage.setItem("accessToken", response.data.accessToken);
        document.cookie = `refreshToken=${response.data.refreshToken}; path=/; Secure;`;

        error.config.headers.Authorization = `Bearer ${response.data.accessToken}`;
        return axios(error.config);
      } catch (refreshError) {
        console.error("Session expired. Logging out...");
        logout();
      }
    }
    return Promise.reject(error);
  }
);

export const handleLogout = async () => {
  try {
    await apiClient.post("/auth/logout");
  } catch (error) {
    console.error("Erreur lors de la déconnexion", error);
  }
  logout();
};

export default apiClient;
