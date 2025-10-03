const ApiUtils = {
    /**
     * @param {string} url
     * @param {object} options
     * @returns {Promise<any>}
     */
    Fetch: async (url, options = {}) => {
        try {
            const response = await fetch("http://localhost:8080" + url, {
                headers: {
                    "Content-Type": "application/json",
                    ...(options.headers || {}),
                },
                ...options,
            });

            return response;
        } catch (err) {
            console.error("Fetch failed:", err);
            throw err;
        }
    },
};

export default ApiUtils;
