import { NextResponse } from "next/server";

export function middleware(request) {
  const accessToken = request.cookies.get("accessToken")?.value;
  const isLoginPage = request.nextUrl.pathname === "/login";

  if (!accessToken && !isLoginPage) {
    return NextResponse.redirect(new URL("/login", request.url));
  }

  if (accessToken && isLoginPage) {
    return NextResponse.redirect(new URL("/", request.url));
  }

  return NextResponse.next();
}

export const config = {
  matcher: ["/((?!_next/static|_next/image|favicon.ico|api).*)"], // ignore statiques + API
};
