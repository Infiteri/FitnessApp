const Utils = {
    /**
     * @param {string} phone 
     * @returns {boolean}
     */
    ValidatePhoneNumber: (phone) => {
        if (!phone) return false;
        if (!phone.startsWith("+")) return false;
        if (!/^\+[0-9]+$/.test(phone)) return false;

        return true;
    },

    /**
     * @param {string} phone 
     * @returns {string}
     */
    FormatPhoneNumber: (phone) => {
        return phone.replace("+", "%2B"); 
    }
};

export default Utils;
