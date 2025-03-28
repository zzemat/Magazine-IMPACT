"use client";
import { useState } from "react";
import Image from "next/image";
import Footer from "../Components/Footer";
import { useRouter } from "next/navigation";
import Logo from "../assets/logo.png";
import Google from "../assets/google.png";
import Link from "next/link";
import apiClient from "../utils/apiClient"; // Import du client API

export default function Login() {
  const router = useRouter();
  const [credentials, setCredentials] = useState({ email: "", password: "" });
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setCredentials({ ...credentials, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");

    try {
      const response = await apiClient.post("/auth/signin", credentials);

      // Stocker accessToken dans localStorage
      localStorage.setItem("accessToken", response.data.accessToken);

      // Stocker refreshToken dans les cookies (HTTPOnly Secure)
      document.cookie = `refreshToken=${response.data.refreshToken}; path=/; Secure;`;

      router.push("/welcome");
    } catch (err) {
      setError("Email ou mot de passe invalide.");
    }
  };

  return (
    <>
      <div className="flex flex-col items-center min-h-[90vh] bg-white">
        <div className="flex justify-center py-2">
          <Image src={Logo} alt="Logo" width={200} height={50} />
        </div>
        <div className="w-full max-w-md bg-white p-8 rounded-3xl shadow-sm border border-2">
          <h2 className="text-center text-gray-700 mb-4">Se connecter avec</h2>
          <div className="flex items-center justify-center">
            <Link
              href="#"
              className="w-full max-w-xs border border-gray-300 rounded-lg py-3 flex justify-center items-center shadow-md hover:bg-gray-50"
            >
              <Image src={Google} alt="Google Logo" width={27} height={27} />
            </Link>
          </div>

          <p className="text-center my-4 text-gray-500">ou</p>

          {error && <p className="text-red-500 text-center">{error}</p>}

          <form onSubmit={handleSubmit}>
            <input
              type="email"
              name="email"
              placeholder="Email"
              className="w-full p-2 mb-3 border rounded-lg focus:outline-none"
              value={credentials.email}
              onChange={handleChange}
            />
            <input
              type="password"
              name="password"
              placeholder="Password"
              className="w-full p-2 mb-3 border rounded-lg focus:outline-none"
              value={credentials.password}
              onChange={handleChange}
            />
            <div className="flex items-center mb-4">
              <input type="checkbox" id="remember" className="mr-2" />
              <label htmlFor="remember">souviens-toi de moi</label>
            </div>
            <button
              type="submit"
              className="w-full p-3 bg-yellow-500 text-white rounded-lg shadow-md hover:bg-yellow-600"
            >
              Se connecter
            </button>
          </form>

          <p className="text-center mt-4 text-gray-700">
            vous n’avez pas un compte ?{" "}
            <Link href="/register" className="font-bold hover:underline">
              s’inscrire
            </Link>
          </p>
        </div>
      </div>
      <div className="mt-1">
        <Footer />
      </div>
    </>
  );
}
