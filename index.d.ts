declare module 'react-native-video-cache' {
  function convert(url: string): string;
  function convertAsync(url: string): Promise<string>;

  export default convert;
  export const convertAsync;
}
