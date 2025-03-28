"use client"

import React, { useState, useEffect } from 'react';
import { io } from 'socket.io-client';


const Notification = () => {
  const [notifications, setNotifications] = useState([]);
  const [isDropdownOpen, setIsDropdownOpen] = useState(false);

  useEffect(() => {
    // Connect to the WebSocket server
    const socket = io('http://localhost:3000');

    // Listen for new notifications
    socket.on('new-notification', (newNotification) => {
      setNotifications((prevNotifications) => [newNotification, ...prevNotifications]);
    });

    return () => {
      socket.disconnect();
    };
  }, []);

  // Mark notification as read
  const markAsRead = (id) => {
    setNotifications((prevNotifications) =>
      prevNotifications.map((notif) =>
        notif.id === id ? { ...notif, isRead: true } : notif
      )
    );
  };

  const unreadCount = notifications.filter((notif) => !notif.isRead).length;

  return (
    <div className="relative">
      {/* Notification Icon */}
      <button
        className="p-2"
        onClick={() => setIsDropdownOpen(!isDropdownOpen)}
      >
        <i className="bell-icon"></i> 
        {unreadCount > 0 && (
          <span className="absolute top-0 right-0 rounded-full bg-red-500 text-white text-xs px-2 py-1">
            {unreadCount}
          </span>
        )}
      </button>

      {/* Notification Dropdown */}
      {isDropdownOpen && (
        <div className="absolute right-0 mt-2 w-80 bg-white shadow-lg rounded-lg">
          <div className="p-2 text-lg font-semibold">Notifications</div>
          <div className="max-h-60 overflow-y-auto">
            {notifications.length > 0 ? (
              notifications.map((notif) => (
                <div
                  key={notif.id}
                  onClick={() => markAsRead(notif.id)}
                  className={`p-3 cursor-pointer ${notif.isRead ? 'bg-gray-100' : 'bg-blue-100'}`}
                >
                  <div className="text-sm">{notif.content}</div>
                </div>
              ))
            ) : (
              <div className="p-4 text-gray-500">No notifications</div>
            )}
          </div>
        </div>
      )}
    </div>
  );
};

export default Notification;
