export const REST_ENDPOINT =
    process.env.NODE_ENV === "development"
        ? "http://localhost:6212"
        : "heroku_url";
