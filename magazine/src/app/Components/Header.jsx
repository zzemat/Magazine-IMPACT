"use client"
import React, { useState } from 'react'
import Link from 'next/link';
import Image from 'next/image';
import Logo from '../assets/magLogo.png'

const Header = () => {
    const [menuOpen, setMenuOpen] = useState(false);

    const menuItems = [
        { label: 'Home', href: '#home' },
        { label: 'About', href: '#about' },
        { label: 'Services', href: '#services' },
        { label: 'Contact', href: '#contact' },
    ];

    return (
        <nav className="top-0 left-0 right-0 z-50">
            <div className="flex items-center justify-between h-16 px-10 pt-3">
                <Image className='w-36 cursor-pointer' src={Logo} alt='logo' width={200} height={50} />
                <div className="hidden md:flex">
                    <div className="ml-10 mr-10 flex items-center space-x-5">
                        {menuItems.map((item) => (
                            <Link
                                key={item.label}
                                href={item.href}
                                className="text-gray-700 hover:text-[#FDAD12] px-3 py-2 rounded-md text-sm font-bold transition-colors duration-200"
                            >
                                {item.label}
                            </Link>
                        ))}
                    </div>
                    <button
                        className="bg-[#FDAD12] text-white font-bold py-2 px-10 rounded-full shadow-lg hover:bg-[#FDAD00] active:scale-95 transition-all border-2 border-transparent"
                    >
                        <Link href="/">
                            <span>Log In</span>
                        </Link>
                    </button>
                </div>

                {/* Mobile Menu Button */}
                <button 
                    className="md:hidden flex items-center" 
                    onClick={() => setMenuOpen(!menuOpen)}
                >
                    <svg className="w-8 h-8 text-gray-700" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                        <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M4 6h16M4 12h16M4 18h16" />
                    </svg>
                </button>
            </div>

            {/* Mobile Menu */}
            <div className={`md:hidden ${menuOpen ? 'block' : 'hidden'}`}>
                <div className="flex flex-col items-center space-y-4 py-4">
                    {menuItems.map((item) => (
                        <Link
                            key={item.label}
                            href={item.href}
                            className="text-gray-700 hover:text-[#FDAD12] text-lg font-bold"
                        >
                            {item.label}
                        </Link>
                    ))}
                </div>
                <div className="flex justify-center py-4">
                    <button
                        className="bg-[#FDAD12] text-white font-bold py-2 px-10 rounded-full shadow-lg hover:bg-[#FDAD00] active:scale-95 transition-all border-2 border-transparent"
                    >
                        <Link href="/">
                            <span>Log In</span>
                        </Link>
                    </button>
                </div>
            </div>

            <div className="w-full overflow-hidden">
                <svg
                    viewBox="0 0 1440 60"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                    preserveAspectRatio="none"
                    className="w-full h-full"
                >
                    <path
                        d="M0,42L12.6,38C25.3,34,51,26,76,21C101.1,16,126,14,152,12C176.8,10,202,8,227,14C252.6,20,278,34,303,38C328.4,42,354,36,379,32C404.2,28,429,26,455,28C480,30,505,36,531,34C555.8,32,581,22,606,24C631.6,26,657,40,682,39C707.4,38,733,22,758,15C783.2,8,808,10,834,15C858.9,20,884,28,909,27C934.7,26,960,16,985,15C1010.5,14,1036,22,1061,25C1086.3,28,1112,26,1137,26C1162.1,26,1187,28,1213,33C1237.9,38,1263,46,1288,50C1313.7,54,1339,54,1364,52C1389.5,50,1415,46,1427,44L1440,42L1440,60L1427.4,60C1414.7,60,1389,60,1364,60C1338.9,60,1314,60,1288,60C1263.2,60,1238,60,1213,60C1187.4,60,1162,60,1137,60C1111.6,60,1086,60,1061,60C1035.8,60,1011,60,985,60C960,60,935,60,909,60C884.2,60,859,60,834,60C808.4,60,783,60,758,60C732.6,60,707,60,682,60C656.8,60,632,60,606,60C581.1,60,556,60,531,60C505.3,60,480,60,455,60C429.5,60,404,60,379,60C353.7,60,328,60,303,60C277.9,60,253,60,227,60C202.1,60,177,60,152,60C126.3,60,101,60,76,60C50.5,60,25,60,13,60L0,60Z"
                        fill="#FDAD12"
                    />
                </svg>
            </div>
        </nav>
    )
}

export default Header;
