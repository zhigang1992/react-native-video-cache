export default function convert(url: string): string;

export function convertAsync(url: string): Promise<string>;

export function setIgnoreUrlParams(shouldIgnore: boolean): Promise<string>;
