# Case Study – Approach Summary

This document explains the approach and reasoning behind each deliverable in the Backend Intern case study.

---

## 1️⃣ Special Cipher
- First applied Caesar Cipher shift on each character
- Then executed Run Length Encoding (RLE)
- Ensures output is compact and correct
- **Time Complexity**: O(n)

---

## 2️⃣ Coin Optimizer
- Used dynamic programming to compute minimum coins needed from 1–99
- Iteratively modified coin values to reduce total coin count
- Stops when no further optimization possible
- **Time Complexity**: Approx. O(N × 100 × V)

---

## 3️⃣ Amazon Product Metadata
Designed metadata for a shirt including:
- Brand, size, color, material, category, SKU, images
- **Separated static metadata vs. dynamic properties**
- Explained how metadata improves search, recommendations, forecasting & catalog management

---

## 4️⃣ Portfolio System HLD
- Created event-driven architecture using AWS
- Price refresh every 10 minutes using EventBridge
- Real-time portfolio served from Redis
- Ensures scalability, reliability, and low-latency

---

### Final Note
Solutions are designed to be:
✔ Clean  
✔ Scalable  
✔ Aligned with problem statement  
✔ Realistic for production use
