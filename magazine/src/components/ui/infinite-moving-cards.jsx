"use client";

import React, { useEffect, useState } from "react";
import { FaLinkedin, FaGlobe, FaInstagram } from "react-icons/fa";

export const InfiniteMovingCards = ({
  items,
  direction = "left",
  speed = "fast",
  pauseOnHover = true,
  className
}) => {
  const containerRef = React.useRef(null);
  const scrollerRef = React.useRef(null);

  useEffect(() => {
    addAnimation();
  }, []);

  const [start, setStart] = useState(false);

  function addAnimation() {
    if (containerRef.current && scrollerRef.current) {
      const scrollerContent = Array.from(scrollerRef.current.children);

      scrollerContent.forEach((item) => {
        const duplicatedItem = item.cloneNode(true);
        if (scrollerRef.current) {
          scrollerRef.current.appendChild(duplicatedItem);
        }
      });

      getDirection();
      getSpeed();
      setStart(true);
    }
  }

  const getDirection = () => {
    if (containerRef.current) {
      containerRef.current.style.setProperty(
        "--animation-direction",
        direction === "left" ? "forwards" : "reverse"
      );
    }
  };

  const getSpeed = () => {
    if (containerRef.current) {
      const duration = speed === "fast" ? "20s" : speed === "normal" ? "40s" : "80s";
      containerRef.current.style.setProperty("--animation-duration", duration);
    }
  };

  return (
    <div
      ref={containerRef}
      className={`scroller relative z-20 max-w-7xl overflow-hidden ${className}`}
    >
      <ul
        ref={scrollerRef}
        className={`flex min-w-full shrink-0 gap-4 py-4 w-max flex-nowrap ${start ? "animate-scroll" : ""
          } ${pauseOnHover ? "hover:[animation-play-state:paused]" : ""}`}
      >
        {items.map((item, idx) => (
          <li
            key={idx}
            className="w-[300px]  max-w-full relative rounded-2xl border border-gray-600 p-4 bg-white dark:bg-gray-900 flex-shrink-0 shadow-lg"
          >
            {/* Image */}
            <img
              src={item.image}
              alt={item.name}
              className="w-full h-80 object-cover rounded-lg"
            />

            {/* Nom & Description */}
            <h3 className="text-lg font-semibold mt-3 text-black dark:text-white">
              {item.name}
            </h3>
            <p className="text-gray-600 text-sm mt-1 dark:text-gray-400">
              {item.description}
            </p>

            {/* Social */}
            <div className="flex justify-start mt-4 text-gray-500 dark:text-gray-400 space-x-4">
        {item.link1 && (
          <a href={item.link1} target="_blank" rel="noopener noreferrer">
            <FaLinkedin className="cursor-pointer transition-all duration-300 hover:opacity-75 text-2xl" />
          </a>
        )}
        {item.link2 && (
          <a href={item.link2} target="_blank" rel="noopener noreferrer">
            <FaGlobe className="cursor-pointer transition-all duration-300 hover:opacity-75 text-2xl" />
          </a>
        )}
        {item.link3 && (
          <a href={item.link3} target="_blank" rel="noopener noreferrer">
            <FaInstagram className="cursor-pointer transition-all duration-300 hover:opacity-75 text-2xl" />
          </a>
        )}
      

            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};
