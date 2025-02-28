"use client"
import React, { useState } from 'react'
import { BackgroundLines } from '@/components/ui/background-lines'
import { FlipWords } from '@/components/ui/flip-words'
import Hero1 from '../assets/hero1.png'
import Hero2 from '../assets/hero2.png'
import Hero3 from '../assets/hero3.png'
import Hero4 from '../assets/hero44.png'
import Hero5 from '../assets/hero5.png'
import Image from 'next/image'
import Link from 'next/link'

const Hero = () => {
  const words = ["Exprimez", "Partagez", "Connectez"];

  return (
    <div className="relative flex flex-col items-center justify-center">
      <BackgroundLines className="flex items-center justify-center w-full flex-col px-4 bg-[#FDAD12]">
        <h2 className="bg-clip-text text-transparent text-center bg-gradient-to-b from-neutral-900 to-neutral-700 dark:to-white text-2xl md:text-4xl lg:text-5xl font-sans pb-5 relative z-20 font-bold tracking-tight">
          Plateforme Étudiant Pour <br /> <FlipWords words={words} />
        </h2>
        <p className="max-w-xl mx-auto text-sm md:text-lg text-neutral-700 text-center">
          Magazine Impact est un espace dédié aux étudiants pour s’exprimer librement, partager leurs idées et se connecter avec une communauté engagée.
        </p>
        <button className="mt-3 mb-3 z-10 bg-[#FFFFFF] font-bold py-2 px-10 rounded-full shadow-lg hover:bg-[#FFFFF1] active:scale-95 transition-all border-2 border-transparent">
          <Link href="#services">
            <span>More</span>
          </Link>
        </button>
      </BackgroundLines>

      <div className="flex  flex-col md:flex-row justify-between items-center absolute z-10 md:top-[85vh]  top-[50vh] w-[80%] px-4 md:px-10">

        <div className="flex flex-col items-center md:mr-20 mb-16 md:mb-0 ">
          <Image src={Hero5} alt='img' className="mb-3 hover:scale-110 transition-transform duration-500 cursor-pointer" />
          <Image src={Hero3} alt='img' className='md:mb-8 hover:scale-110 transition-transform duration-500 cursor-pointer' />
        </div>

        <div className="flex justify-center items-center md:mr-20 mb-16 md:mb-0">
          <Image src={Hero4} height={650}  alt='img' className='hover:scale-110 transition-transform duration-500 cursor-pointer'/>
        </div>

        <div className="flex flex-col items-center mb-16 md:mb-0 ">
          <Image src={Hero2} alt='img' className="mb-3 hover:scale-110 transition-transform duration-500 cursor-pointer" />
          <Image src={Hero1} alt='img' className='hover:scale-110 transition-transform duration-500 cursor-pointer' />
        </div>

      </div>
    </div>
  )
}

export default Hero;
