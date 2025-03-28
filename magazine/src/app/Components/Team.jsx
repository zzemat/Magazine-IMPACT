"use client";

import React from "react";
import { InfiniteMovingCards } from "@/components/ui/infinite-moving-cards";
import Mouad from '../assets/mouad.jpg'

const Team = () => {
  return (
    <div>
      <div className='flex flex-col justify-start items-start ml-4 md:ml-14'>
        <p className='text-black/40 text-sm sm:text-base'>Notre Equipe</p>
        <h1 className='text-[#4F4E4E] font-bold text-2xl sm:text-4xl text-left'>A partir l'etudiant a l'etudiant</h1>
      </div>
      <div className="mt-10 rounded-md flex flex-col antialiased text-black bg-white dark:bg-black dark:bg-grid-white/[0.05] items-start justify-center relative overflow-hidden">
        <InfiniteMovingCards items={testimonials} direction="right" speed="normal" />
      </div>
    </div>
  );
};

const testimonials = [
  {
    image: Mouad.src,
    name: "Mouad Sadik",
    description: "Frontend Developper",
    link1: "https://www.linkedin.com/in/mouad-sadik-5b8907257/",
    link2: "https://mouadsadik.vercel.app/",
    link3: "https://www.instagram.com/mouad_sadik_?igsh=NXoyNzhjamozZTFt",
  },
  {
    image: Mouad.src,
    name: "Mouad Sadik",
    description: "Frontend Developper",
    link1: "https://www.linkedin.com/in/mouad-sadik-5b8907257/",
    link2: "https://mouadsadik.vercel.app/",
    link3: "https://www.instagram.com/mouad_sadik_?igsh=NXoyNzhjamozZTFt",
  },
  {
    image: Mouad.src,
    name: "Mouad Sadik",
    description: "Frontend Developper",
  },
  {
    image: Mouad.src,
    name: "Mouad Sadik",
    description: "Frontend Developper",
  },
  {
    image: Mouad.src,
    name: "Mouad Sadik",
    description: "Frontend Developper",
  },
  {
    image: Mouad.src,
    name: "Mouad Sadik",
    description: "Frontend Developper",
  },
];

export default Team;
