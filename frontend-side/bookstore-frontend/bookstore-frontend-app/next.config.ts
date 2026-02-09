import type { NextConfig } from "next";

const nextConfig: NextConfig = {
  /* config options here */
  webpackDevMiddleware: config => {
    config.watchOptions = {
      poll: 1000, // verifica mudanças a cada 1000ms
      aggregateTimeout: 300,
    };
    return config;
  }
};

export default nextConfig;
