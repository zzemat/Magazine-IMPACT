
import Link from "next/link";
import { FaLinkedin, FaFacebook, FaInstagram, FaYoutube } from "react-icons/fa";

export default function Footer() {
  return (
    <>
      <div className="w-full h-6 rotate-180 -mb-20 z-0">
        <svg viewBox="0 0 1440 100" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path
            d="M0 40 C100 80, 200 20, 300 50 C400 90, 500 10, 600 40 C700 70, 800 30, 900 50 C1000 70, 1100 20, 1200 40 C1300 60, 1400 20, 1440 50 L1440 100 L0 100 Z"
            className="fill-current text-white"
          ></path>
        </svg>
      </div>

      <footer className="bg-yellow-500 text-white pt-10 pb-6">
        <div className="container p-4 grid grid-cols-3 items-center px-12">
          <div className="text-left">
            <Link href="/about" className="hover:underline">About</Link>
            <Link href="/contact" className="hover:underline ml-4">Contact</Link>
            <Link href="/privacy-policy" className="hover:underline ml-4">Politique et confidentialité</Link>
          </div>

          <div className="text-center">
            <p>© 2025 Magazine Impact</p>
          </div>

          <div className="text-right flex justify-end space-x-4">
            <Link href="#"><FaLinkedin className="text-white text-3xl hover:text-gray-300" /></Link>
            <Link href="#"><FaFacebook className="text-white text-3xl hover:text-gray-300" /></Link>
            <Link href="#"><FaInstagram className="text-white text-3xl hover:text-gray-300" /></Link>
            <Link href="#"><FaYoutube className="text-white text-3xl hover:text-gray-300" /></Link>
          </div>
        </div>
      </footer>
    </>
  );
}
