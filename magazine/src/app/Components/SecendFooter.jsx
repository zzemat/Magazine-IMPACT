import React from 'react'
import { FaLinkedinIn, FaFacebookF, FaInstagram, FaYoutube } from 'react-icons/fa'
import Image from 'next/image'
import Link from 'next/link'
import WhiteLogo from '../assets/whitelogo2.png'

const SecendFooter = () => {
    return (
        <footer className="bg-[#FDAD12] text-white pt-20 pb-10 mt-20 " id="contact">
            <div className="container mx-auto px-4 text-center mb-10">
                <h3 className="uppercase text-sm font-light tracking-wider mb-4">UPSKILL FOR A BETTER FUTURE</h3>
                <h2 className="text-4xl font-bold mb-6">Request More Information</h2>
                <p className="max-w-lg mx-auto mb-8">
                    Lift Media, LLC is a clinical stage healthcare company which is developing a unique.
                </p>
                <button className="bg-gray-100 mt-8 text-gray-700 px-8 py-3 rounded-full font-medium shadow-md hover:bg-gray-200 transition duration-300">
                    Contact Us
                </button>
            </div>

            <div className="text-center  mb-12 text-sm">
                © 2025 Magazine IMpact
            </div>

            <div className="h-px bg-[#0A142F] opacity-30 w-full my-8"></div>

            <div className="container mx-auto px-14">
                <div className="flex flex-col md:flex-row justify-between items-center">

                <div className="mb-6 md:mb-0">
                    <Link href="#home" alt="logo">
                        <Image 
                            className="" 
                            src= {WhiteLogo} 
                            alt="logo"
                            width={150}
                            height={60}
                        />
                    </Link>
                </div>

                    <div className="flex space-x-8 mb-6 md:mb-0">
                        <a href="#home" className="hover:underline">Home</a>
                        <a href="#about" className="hover:underline">About</a>
                        <a href="#services" className="hover:underline">Services</a>
                    </div>

                    <div className="flex space-x-6">
                        <a href="https://www.linkedin.com/in/club-impact-fsts-a461452b4/" className="hover:opacity-80">
                            <FaLinkedinIn className="h-5 w-5" />
                        </a>
                        <a href="#" className="hover:opacity-80">
                            <FaFacebookF className="h-5 w-5" />
                        </a>
                        <a href="#" className="hover:opacity-80">
                            <FaInstagram className="h-5 w-5" />
                        </a>
                        <a href="#" className="hover:opacity-80">
                            <FaYoutube className="h-5 w-5" />
                        </a>
                    </div>
                </div>


            </div>
        </footer>
    )
}

export default SecendFooter