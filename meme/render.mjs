// Renders skill-unlock.html to a 1080x1920 PNG.
//   node meme/render.mjs [out.png]
import { chromium } from 'playwright';
import { fileURLToPath } from 'node:url';
import path from 'node:path';

const here = path.dirname(fileURLToPath(import.meta.url));
const out = process.argv[2] ?? path.join(here, 'out', 'haeni-mobility-unlocked.png');

const browser = await chromium.launch();
const page = await browser.newPage({ viewport: { width: 1080, height: 1920 }, deviceScaleFactor: 1 });
await page.goto('file://' + path.join(here, 'skill-unlock.html'), { waitUntil: 'networkidle' });
await page.evaluate(() => document.fonts.ready);
await page.screenshot({ path: out, clip: { x: 0, y: 0, width: 1080, height: 1920 } });
await browser.close();
console.log('wrote', out);
